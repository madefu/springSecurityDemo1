package com.madefu.mybatisgeneratorplugin;

//package com.tripalink.tech.backend.mybatis.generator.plugins;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.type.JdbcType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.*;

import org.mybatis.generator.codegen.mybatis3.MyBatis3FormattingUtilities;

import java.util.List;

public class PGArrayOperatorsPlugin extends PluginAdapter {

    public static void main(String[] args) {
        LOGGER.info("done!");
    }

    private static final Logger LOGGER = LogManager.getLogger(PGArrayOperatorsPlugin.class);

    public PGArrayOperatorsPlugin() {
        super();
    }

    @Override
    public boolean validate(List<String> list) {
        return true;
    }

    @Override
    public boolean modelExampleClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        topLevelClass.getInnerClasses().stream()
                .filter(this::isGeneratedCriteria)
                .findFirst()
                .ifPresent(c -> addCriteriaMethodsForArrayColumns(introspectedTable, c));
        return true;
    }

    protected boolean isGeneratedCriteria(InnerClass innerClass) {
        return "GeneratedCriteria".equals(innerClass.getType().getShortName());
    }

    protected void addCriteriaMethodsForArrayColumns(IntrospectedTable introspectedTable, InnerClass criteria) {
        List<IntrospectedColumn> nonBLOBColumns = introspectedTable.getNonBLOBColumns();
        for (IntrospectedColumn nonBLOBColumn : nonBLOBColumns) {
            if (!isArrayColumn(nonBLOBColumn)) {
                continue;
            }
            LOGGER.debug(
                    "Found that column {} has type Array, adding custom criteria methods for it",
                    nonBLOBColumn.getActualColumnName()
            );
            criteria.addMethod(createContainsCriteriaMethod(nonBLOBColumn, criteria));
            criteria.addMethod(createIsContainedByCriteriaMethod(nonBLOBColumn, criteria));
            criteria.addMethod(createOverlapsCriteriaMethod(nonBLOBColumn, criteria));
            LOGGER.debug(
                    "Adding custom criteria methods for column {} done",
                    nonBLOBColumn.getActualColumnName()
            );
        }
    }

    protected boolean isArrayColumn(IntrospectedColumn introspectedColumn) {
        return StringUtils.equals(introspectedColumn.getJdbcTypeName(), JdbcType.ARRAY.name());
    }

    protected Method createContainsCriteriaMethod(IntrospectedColumn introspectedColumn, InnerClass criteria) {
        String criteriaMethodName = "and" +
                StringUtils.capitalize(introspectedColumn.getJavaProperty()) +
                "Contains";

        LOGGER.debug("Generating the criteria method: {}", criteriaMethodName);

        Method method = new Method(criteriaMethodName);
        method.setVisibility(JavaVisibility.PUBLIC);
        method.addParameter(
                new Parameter(introspectedColumn.getFullyQualifiedJavaType(), "value")
        );
        method.setReturnType(FullyQualifiedJavaType.getCriteriaInstance());

        method.addBodyLine(
                buildFirstLineMethodBody(
                        introspectedColumn,
                        criteria,
                        "\"%s @>\", value, \"%s\""
                )
        );
        method.addBodyLine("return (Criteria) this;");

        LOGGER.debug("Generating the criteria method: {} done", criteriaMethodName);

        return method;
    }

    protected Method createIsContainedByCriteriaMethod(IntrospectedColumn introspectedColumn, InnerClass criteria) {
        String criteriaMethodName = "and" +
                StringUtils.capitalize(introspectedColumn.getJavaProperty()) +
                "IsContainedBy";

        LOGGER.debug("Generating the criteria method: {}", criteriaMethodName);

        Method method = new Method(criteriaMethodName);
        method.setVisibility(JavaVisibility.PUBLIC);
        method.addParameter(
                new Parameter(introspectedColumn.getFullyQualifiedJavaType(), "value")
        );
        method.setReturnType(FullyQualifiedJavaType.getCriteriaInstance());

        method.addBodyLine(
                buildFirstLineMethodBody(
                        introspectedColumn,
                        criteria,
                        "\"%s <@\", value, \"%s\""
                )
        );
        method.addBodyLine("return (Criteria) this;");

        LOGGER.debug("Generating the criteria method: {} done", criteriaMethodName);

        return method;
    }

    protected Method createOverlapsCriteriaMethod(IntrospectedColumn introspectedColumn, InnerClass criteria) {
        String criteriaMethodName = "and" +
                StringUtils.capitalize(introspectedColumn.getJavaProperty()) +
                "OverlapsWith";

        LOGGER.debug("Generating the criteria method: {}", criteriaMethodName);

        Method method = new Method(criteriaMethodName);
        method.setVisibility(JavaVisibility.PUBLIC);
        method.addParameter(
                new Parameter(introspectedColumn.getFullyQualifiedJavaType(), "value")
        );
        method.setReturnType(FullyQualifiedJavaType.getCriteriaInstance());

        method.addBodyLine(
                buildFirstLineMethodBody(
                        introspectedColumn,
                        criteria,
                        "\"%s &&\", value, \"%s\""
                )
        );
        method.addBodyLine("return (Criteria) this;");

        LOGGER.debug("Generating the criteria method: {} done", criteriaMethodName);

        return method;
    }

    private String buildFirstLineMethodBody(IntrospectedColumn introspectedColumn,
                                            InnerClass criteria, String addCriterionMethodParamTemplate) {
        StringBuilder sb = new StringBuilder();
        Method addCriterionMethod = criteria.getMethods().stream().filter(m ->
                StringUtils.equals(m.getName(),
                        String.format(
                                "add%sCriterion",
                                StringUtils.capitalize(introspectedColumn.getJavaProperty())
                        )
                )
        ).findAny().orElse(null);

        if (addCriterionMethod != null) {
            sb.append(
                    String.format("%s(" + addCriterionMethodParamTemplate + ");",
                            addCriterionMethod.getName(),
                            MyBatis3FormattingUtilities.getAliasedActualColumnName(introspectedColumn),
                            introspectedColumn.getJavaProperty()
                    )
            );
        } else {
            sb.append(
                    String.format("addCriterion(" + addCriterionMethodParamTemplate + ");",
                            MyBatis3FormattingUtilities.getAliasedActualColumnName(introspectedColumn),
                            introspectedColumn.getJavaProperty()
                    )
            );
        }

        return sb.toString();
    }

}


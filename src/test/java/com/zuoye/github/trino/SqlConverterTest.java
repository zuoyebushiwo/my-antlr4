package com.zuoye.github.trino;

import com.google.common.collect.Lists;
import com.zuoye.github.trino.proto.AuthorityManagementRequest;
import com.zuoye.github.trino.proto.AuthorityManagementResponse;
import io.trino.sql.parser.StatementSplitter;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.List;

public class SqlConverterTest {

    @Test
    public void testCreateTable() {

        List<String> statements = splitTrinoSql("tt");;
        if (CollectionUtils.isEmpty(statements)) {
            return;
        }

        for (String statement : statements) {
            AuthorityManagementRequest request = AuthorityManagementRequest.builder()
                    .user("zhangxuejun")
                    .projectCode("my_tenant")
                    .env("dev")
                    .sqlText(statement)
                    .build();
            AuthorityManagementResponse response = authentication(request);
            printResult(response);
        }
    }

    private List<String> splitTrinoSql(String sqlText) {
        sqlText = replaceNotes(sqlText);
        List<String> statements = Lists.newArrayList();

        StatementSplitter splitter = new StatementSplitter(sqlText);
        List<StatementSplitter.Statement> completeStatements = splitter.getCompleteStatements();

        for (StatementSplitter.Statement completeStatement : completeStatements) {
            String statement = completeStatement.statement();
            statements.add(statement);
        }

        String partialStatement = splitter.getPartialStatement();
        if (StringUtils.isNotEmpty(partialStatement)) {
            statements.add(partialStatement);
        }
        return statements;
    }

    /**
     * 替换sql注释
     *
     * @param sqlText sql
     * @return 替换后的sl
     */
    protected String replaceNotes(String sqlText) {
        sqlText = sqlText.replaceAll("\\\\r","");
        sqlText =  sqlText.replaceAll("/\\*[\\s\\S]*?\\*/", "");
        StringBuilder newSql = new StringBuilder();
        String lineBreak = "\n";
        String transLineBreak = "\\\\n";
        String empty = "";
        String trimLine;
        for (String line : sqlText.split(lineBreak)) {
            for (String transLine : line.split(transLineBreak)){
                trimLine = transLine.trim();
                if (!trimLine.startsWith("--") && !trimLine.startsWith("download") && !trimLine.startsWith("#")) {
                    //过滤掉行内注释
                    transLine = trimLine.replaceAll("/\\*.*\\*/", empty);
                    if (StringUtils.isNotBlank(transLine)) {
                        newSql.append(transLine).append(lineBreak);
                    }
                }
            }
        }

        return newSql.toString();
    }

    private void printResult(AuthorityManagementResponse response) {
        System.out.println(response.toString());
    }

    public AuthorityManagementResponse authentication(AuthorityManagementRequest request) {
        SqlConverter converter = new SqlConverter();
        converter.authentication();
        return null;
    }

}
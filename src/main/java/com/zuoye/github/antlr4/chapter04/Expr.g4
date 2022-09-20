grammar Expr;
import CommonLexerRules;
prog: stat+ ;
stat: expr NEWLINE
    | ID '=' expr NEWLINE
    | NEW_LINE;
expr: expr ('*'|'/') expr
    | expr ('+'|'-') expr
    | INT
    | ID
    | '(' expr ')'
    ;
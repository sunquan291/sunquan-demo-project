grammar ISL;
/*@header
*{
*     using System;
*}
*/
/*@members
*{
*}
*/
/*
* Parser Rules
*/
/*
* 表达式
*/
expression
    : NUMBER            #Number
    | STRING            #String
    | VARIABLE            #Variable
    | SUB expression    #SubExpr
    | expression op=(MUL|DIV) expression    #MulDiv
    | expression op=(ADD|SUB) expression    #AddSub
    | LEFT_PAREN expression RIGHT_PAREN        #Paren
;
equality_expression
    : TRUE        #LogicalTrue
    | FALSE        #LogicalFalse
    | expression op=(GREATE_THAN | GREATE_EQUAL_THAN | LESS_THAN | LESS_EQUAL_THAN | EQUAL | NOT_EQUAL) expression    #LogicalOp
    | equality_expression op=(LOGICAL_NOT | LOGICAL_AND | LOGICAL_OR | EQUAL | NOT_EQUAL) equality_expression    #LogicalAndOrNot
    | LEFT_PAREN equality_expression RIGHT_PAREN        #Paren2
;
/*
* 返回语句
*/
return_statement
        : RETURN equality_expression SEMICOLON    #Return
;
elseif_list
    : elseif+
    //| elseif_list elseif
;
elseif
    : ELSEIF LEFT_PAREN expression RIGHT_PAREN block
;
if_statement
    : IF LEFT_PAREN expression RIGHT_PAREN block
    | IF LEFT_PAREN expression RIGHT_PAREN block ELSE block
    | IF LEFT_PAREN expression RIGHT_PAREN block elseif_list
    | IF LEFT_PAREN expression RIGHT_PAREN block elseif_list ELSE block
;
statement
        : expression SEMICOLON
        | if_statement
;
block
    : LEFT_CURLY statement_list RIGHT_CURLY
    | LEFT_CURLY RIGHT_CURLY
;
statement_list
        : statement+
;
/*
* Lexer Rules
*/
VARIABLE : '[车速]' | '[天气]' | '[时间]' | '[企业ID]' | '[用户ID]';             // 数字变量
NUMBER : [1-9][0-9]*|[0]|([0-9]+[.][0-9]+) ;     // 数字
STRING : '"' ('\\"'|.)*? '"' ; // 字符串
WS : [ \t\r\n]+ -> skip ; // skip spaces, tabs, newlines
ADD : '+' ;
SUB : '-' ;
MUL : '*' ;
DIV : '/' ;
MOD : '%' ;
GREATE_THAN : '>' ;
GREATE_EQUAL_THAN : '>=' ;
LESS_THAN : '<' ;
LESS_EQUAL_THAN : '<=' ;
EQUAL : '==' ;
TRUE : 'true' ;
FALSE : 'false' ;
NOT_EQUAL : '!=' ;
LOGICAL_AND : '&&' ;
LOGICAL_OR : '||' ;
LOGICAL_NOT : '!' ;
LEFT_PAREN : '(' ;
RIGHT_PAREN : ')' ;
LEFT_CURLY : '{' ;
RIGHT_CURLY : '}' ;
CR : '\n' ;
IF : 'if' ;
ELSE : 'else' ;
ELSEIF : 'else if' ;
SEMICOLON : ';' ;
DOUBLE_QUOTATION : '"' ;
RETURN : 'return' ;
LINE_COMMENT : '//' .*? '\n' -> skip ;
COMMENT : '/*' .*? '*/' -> skip ;
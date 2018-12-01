/**short[] data = {1, 2, 3} 翻译成 string data = "\u0001\u0002\u0003"
* 指将short数组里每个数据转成unicode编译后的字符串
*/
grammar DemoTransUnicode;

init : '{' value (',' value)* '}';
value : init | INT;
INT : [0-9]+;
/**WS  : [ \t\r\n]+ -> skip ;*/



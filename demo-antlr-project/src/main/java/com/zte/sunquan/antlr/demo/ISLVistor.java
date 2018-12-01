//package com.zte.sunquan.antlr.demo;
//
//import com.zte.sunquan.antlr.isl.ISLBaseVisitor;
//import com.zte.sunquan.antlr.isl.ISLParser;
//
///**
// * Created by Administrator on 2017/3/23.
// */
//public class ISLVistor extends ISLBaseVisitor<Result> {
//    public Result visitNumber(ISLParser.NumberContext context) {
//        Result r = new Result();
//        r.value = Double.parseDouble(context.NUMBER().getText());
//        r.text = context.NUMBER().getText();
//        return r;
//    }
//
//    public Result visitParen(ISLParser.ParenContext context) {
//        Result o = visit(context.expression());
//        o.text = "(" + o.text + ")";
//        return o;
//    }
//
//    public Result visitParen2(ISLParser.Paren2Context context) {
//        Result o = visit(context.equality_expression());
//        o.text = "(" + o.text + ")";
//        return o;
//    }
//
//    public Result visitMulDiv(ISLParser.MulDivContext context) {
//        Result r = new Result();
//        double left = Double.parseDouble(visit(context.expression(0)).value.toString());
//        double right = Double.parseDouble(visit(context.expression(1)).value.toString());
//        if (context.op.getType() == ISLParser.MUL) {
//            r.value = left * right;
//            r.text = visit(context.expression(0)).text + " 乘以 " + visit(context.expression(1)).text;
//        }
//        if (context.op.getType() == ISLParser.DIV) {
//            r.value = left / right;
//            r.text = visit(context.expression(0)).text + " 除以 " + visit(context.expression(1)).text;
//        }
//        return r;
//    }
//
//    public Result visitAddSub(ISLParser.AddSubContext context) {
//        Result r = new Result();
//        double left = (double) visit(context.expression(0)).value;
//        double right = (double) visit(context.expression(1)).value;
//        if (context.op.getType() == ISLParser.ADD) {
//            r.value = left + right;
//            r.text = visit(context.expression(0)).text + " 加上 " + visit(context.expression(1)).text;
//        } else {
//            r.value = left - right;
//            r.text = visit(context.expression(0)).text + " 减去 " + visit(context.expression(1)).text;
//        }
//        return r;
//    }
//
//    public Result visitVariable(ISLParser.VariableContext context) {
//        Result r = new Result();
//        if (context.getText() == "[车速]") {
//            r.text = "车速";
////            r.value = TestData.vehicleSpeed;
//        } else if (context.getText() == "[天气]") {
//            r.text = "天气";
////            r.value = TestData.Weather;
//        } else if (context.getText() == "[时间]") {
//            r.text = "时间";
////            r.value = TestData.Now;
//        } else if (context.getText() == "[企业ID]") {
//            r.text = "企业ID";
////            r.value = TestData.EntId;
//        } else if (context.getText() == "[用户ID]") {
//            r.text = "用户ID";
////            r.value = TestData.AccountId;
//        }
//        r.value=context.VARIABLE().getPayload();
//        return r;
//    }
//
//    public Result visitLogicalFalse(ISLParser.LogicalFalseContext context) {
//        Result r = new Result();
//        r.value = false;
//        return r;
//    }
//
//    public Result visitLogicalTrue(ISLParser.LogicalTrueContext context) {
//        Result r = new Result();
//        r.value = true;
//        return r;
//    }
//
//    public Result visitLogicalAndOrNot(ISLParser.LogicalAndOrNotContext context) {
//        Result r = new Result();
//        if (context.op.getType() == ISLParser.LOGICAL_AND) {
//            boolean o1 = Boolean.parseBoolean(visit(context.equality_expression(0)).value.toString());
//            boolean o2 = Boolean.parseBoolean(visit(context.equality_expression(1)).value.toString());
//            r.value = o1 && o2;
//            r.text = visit(context.equality_expression(0)).text + " 并且 " + visit(context.equality_expression(1)).text;
//        }
//        return r;
//    }
//
//    public Result visitString(ISLParser.StringContext context) {
//        Result r = new Result();
//        r.value = context.getText().replace("\"", "");
//        r.text = context.getText().replace("\"", "");
//        return r;
//    }
//
//    public Result visitLogicalOp(ISLParser.LogicalOpContext context) {
//        Result r = new Result();
//        Object result = null;
//        if (context.op.getType() == ISLParser.GREATE_THAN) {
//            double left = Double.parseDouble(visit(context.expression(0)).value.toString());
//            double right = Double.parseDouble(visit(context.expression(1)).value.toString());
//            if (left > right) {
//                result = 1;
//            } else {
//                result = 0;
//            }
//            r.text = visit(context.expression(0)).text + " 大于 " + visit(context.expression(1)).text;
//        }
//        if (context.op.getType() == ISLParser.LESS_THAN) {
//            double left = Double.parseDouble(visit(context.expression(0)).value.toString());
//            double right = Double.parseDouble(visit(context.expression(1)).value.toString());
//            if (left < right) {
//                result = 1;
//            } else {
//                result = 0;
//            }
//            r.text = visit(context.expression(0)).text + " 小于 " + visit(context.expression(1)).text;
//        }
//        if (context.op.getType() == ISLParser.EQUAL) {
//            Object left = visit(context.expression(0)).value;
//            Object right = visit(context.expression(1)).value;
//            if (left instanceof String) {
//                result = left.toString() == right.toString();
//            } else {
//                result = visit(context.expression(0)).value == visit(context.expression(1)).value;
//            }
//            r.text = visit(context.expression(0)).text + " 等于 " + visit(context.expression(1)).text;
//        }
//        r.value = result;
//        return r;
//    }
//
//    public Result visitReturn(ISLParser.ReturnContext context) {
//        Result o = visit(context.equality_expression());
//        return o;
//    }
//}

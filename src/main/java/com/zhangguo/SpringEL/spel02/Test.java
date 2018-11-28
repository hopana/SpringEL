package com.zhangguo.SpringEL.spel02;

import java.util.ArrayList;
import java.util.List;

import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

public class Test {

    public static void main(String[] args) {
		/*
		//创建SpEL表达式的解析器
		ExpressionParser parser=new SpelExpressionParser();
		//解析表达式'Hello '+' World!'
		Expression exp=parser.parseExpression("'Hello '+' World!'");
		//取出解析结果
		String result=exp.getValue().toString();
		//输出结果
		System.out.println(result);
		*/
		
		/*
		ExpressionParser ep= new SpelExpressionParser();
		System.out.println(ep.parseExpression("'HelloWorld'").getValue());
		System.out.println(ep.parseExpression("0xffffff").getValue());
		System.out.println(ep.parseExpression("1.234345e+3").getValue());
		System.out.println(ep.parseExpression("new java.util.Date().toLocaleString()").getValue());
		*/

        //创建SpEL表达式的解析器
        ExpressionParser parser = new SpelExpressionParser();
        User user = new User(9527, "周星驰");
        //解析表达式需要的上下文，解析时有一个默认的上下文
        EvaluationContext ctx = new StandardEvaluationContext();
        //在上下文中设置变量，变量名为user，内容为user对象
        ctx.setVariable("user", user);
        //从用户对象中获得id并+1900，获得解析后的值在ctx上下文中
        int id = (Integer) parser.parseExpression("#user.id + 1900").getValue(ctx);
        System.out.println(id);


        String[] students = new String[]{"tom", "jack", "rose", "mark", "lucy"};
        ctx.setVariable("students", students);
        String student = parser.parseExpression("#students[3]").getValue(ctx, String.class);
        System.out.println(student);

        List numbers = (List) parser.parseExpression("{1,2,3,4,5}").getValue();
        System.out.println(numbers.get(2) + "");
        List listOfLists = (List) parser.parseExpression("{{'a','b'},{'x','y'}}").getValue();
        System.out.println(((List) listOfLists.get(1)).get(1));

        User user1 = new User(9001, "邹任飞");
        User user2 = new User(9002, "练汶峰");
        List<User> users = new ArrayList<User>();
        users.add(user1);
        users.add(user2);
        ctx.setVariable("users", users);
        String name = parser.parseExpression("#users[1].name").getValue(ctx, String.class);
        System.out.println(name);

        String c = parser.parseExpression("'abcdef'.substring(2, 3)").getValue(String.class);
        System.out.println(c);
        String c1 = parser.parseExpression("T(java.lang.Math).random()*1000").getValue(String.class);
        System.out.println(c1);

        //true
        boolean trueValue1 = parser.parseExpression("2 == 2").getValue(Boolean.class);
        //false
        boolean falseValue1 = parser.parseExpression("2 < -5.0").getValue(Boolean.class);
        //true
        boolean trueValue2 = parser.parseExpression("'black' < 'block'").getValue(Boolean.class);
        //false，字符xyz是否为int类型
        boolean falseValue2 = parser.parseExpression("'xyz' instanceof T(int)").getValue(Boolean.class);
        //true，正则是否匹配
        boolean trueValue3 = parser.parseExpression("'5.00' matches '^-?\\d+(\\.\\d{2})?$'").getValue(Boolean.class);
        //false
        boolean falseValue3 = parser.parseExpression("'5.0067' matches '^-?\\d+(\\.\\d{2})?$'").getValue(Boolean.class);


        // -- AND 与运算 --
        //false
        boolean falseValue4 = parser.parseExpression("true and false").getValue(Boolean.class);
        //true，isMember方法用于测试是否为某个对象的成员
        String expression = "isMember('Nikola Tesla') and isMember('Mihajlo Pupin')";
        boolean trueValue4 = parser.parseExpression(expression).getValue(Boolean.class);
        // -- OR 或运算--
        //true
        boolean trueValue5 = parser.parseExpression("true or false").getValue(Boolean.class);
        //true
        String expression1 = "isMember('Nikola Tesla') or isMember('Albert Einstein')";
        boolean trueValue6 = parser.parseExpression(expression).getValue(Boolean.class);
        //false
        boolean falseValue5 = parser.parseExpression("!true").getValue(Boolean.class);
        //false
        String expression2 = "isMember('Nikola Tesla') and !isMember('Mihajlo Pupin')";
        boolean falseValue6 = parser.parseExpression(expression).getValue(Boolean.class);

        // Addition
        // 2
        int two = parser.parseExpression("1 + 1").getValue(Integer.class);
        // 'test string'
        String testString = parser.parseExpression("'test' + ' ' + 'string'").getValue(String.class);
        // Subtraction
        // 4
        int four = parser.parseExpression("1 - -3").getValue(Integer.class);
        // -9000
        double d = parser.parseExpression("1000.00 - 1e4").getValue(Double.class);
        // Multiplication
        // 6
        int six = parser.parseExpression("-2 * -3").getValue(Integer.class);
        // 24.0
        double twentyFour = parser.parseExpression("2.0 * 3e0 * 4").getValue(Double.class);
        // Division
        // -2
        int minusTwo = parser.parseExpression("6 / -3").getValue(Integer.class);
        // 1.0
        double one = parser.parseExpression("8.0 / 4e0 / 2").getValue(Double.class);
        // Modulus
        // 3
        int three = parser.parseExpression("7 % 4").getValue(Integer.class);
        // 1
        int one2 = parser.parseExpression("8 / 5 % 2").getValue(Integer.class);
        // Operator precedence
        // -21
        int minusTwentyOne = parser.parseExpression("1+2-3*8").getValue(Integer.class);
    }
}

package com.zhangguo.SpringEL.spel03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

public class Test {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spel03.xml");
		User user1 = ctx.getBean("user1", User.class);
		System.out.println(user1.getId() + "," + user1.getName());

		Order Order03 = ctx.getBean("Order03", Order.class);
		System.out.println(Order03);

		ExpressionParser ep = new SpelExpressionParser();
		// 关系操作符
		System.out.println(ep.parseExpression("5>2").getValue());
		System.out.println(ep.parseExpression("2 between {1,9}").getValue());
		// 逻辑运算符
		System.out.println(ep.parseExpression("(5>2) and (2==1)").getValue());
		// 算术操作符
		System.out.println(ep.parseExpression("100-2^2").getValue());

        //
        EvaluationContext evctx = new StandardEvaluationContext();
        evctx.setVariable("user1", user1);
        System.out.println(ep.parseExpression("'user1:'+#user1.getName()").getValue(evctx, String.class));

    }
}

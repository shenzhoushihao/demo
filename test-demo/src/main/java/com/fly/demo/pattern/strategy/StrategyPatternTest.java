package com.fly.demo.pattern.strategy;

/**
 * 策略者模式的实现
 *
 */
interface Strategy {
	public void strategyMethod();
}

class ConcreteStrategyA implements Strategy {

	@Override
	public void strategyMethod() {
		System.out.println("具体策略A的策略方法被访问.");
	}
}

class ConcreteStrategyB implements Strategy {

	@Override
	public void strategyMethod() {
		System.out.println("具体策略B的策略方法被访问.");
	}
}

class Context {
	private Strategy strategy;

	public void setStrategy(Strategy strategy) {
		this.strategy = strategy;
	}

	public Strategy getStrategy() {
		return this.strategy;
	}

	public void strategyMethod() {
		strategy.strategyMethod();
	}
}

public class StrategyPatternTest {
	public static void main(String[] args) {
		Context context = new Context();
		Strategy ca = new ConcreteStrategyA();
		context.setStrategy(ca);
		context.strategyMethod();

		Strategy cb = new ConcreteStrategyB();
		context.setStrategy(cb);
		context.strategyMethod();
	}
}
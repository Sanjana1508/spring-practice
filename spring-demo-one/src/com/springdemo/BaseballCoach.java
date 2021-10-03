package com.springdemo;

public class BaseballCoach implements Coach{
	
	private FortuneService fortuneService;
	
	public BaseballCoach(FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "30 mins on batting";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
}

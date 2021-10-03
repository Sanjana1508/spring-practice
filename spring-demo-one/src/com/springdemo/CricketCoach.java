package com.springdemo;

public class CricketCoach implements Coach {
	
	private FortuneService fortuneService;
	
	private String emailAddress;
	private String team;
	private int teamNo;
	
	public int getTeamNo() {
		return teamNo;
	}


	public void setTeamNo(int teamNo) {
		System.out.println("CricketCoach : inside setter - setTeamNo");
		this.teamNo = teamNo;
	}


	public String getEmailAddress() {
		return emailAddress;
	}


	public void setEmailAddress(String emailAddress) {
		System.out.println("CricketCoach : inside setter - setEmailAddress");
		this.emailAddress = emailAddress;
	}


	public String getTeam() {
		return team;
	}


	public void setTeam(String team) {
		System.out.println("CricketCoach : inside setter - setTeam");
		this.team = team;
	}


	public CricketCoach() {
		System.out.println("CricketCoach : inside no-args constructor");
	}

	
	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("CricketCoach : inside setter - setFortuneService");
		this.fortuneService = fortuneService;
	}


	@Override
	public String getDailyWorkout() {
		
		return "fast bowling for 15 mins";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}

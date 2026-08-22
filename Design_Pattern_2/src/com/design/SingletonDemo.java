package com.design;

class Singleton { 
	private static Singleton instance;
	private Singleton() {} 
	public static Singleton getInstance() { 
		if(instance == null) instance = new Singleton();
		return instance; 
		} 
	public void display() { 
		System.out.println("Singleton Object Created"); 
		} 
	}
	public class SingletonDemo { 
		public static void main(String args[]) {
			
			Singleton s1 = Singleton.getInstance(); 
			Singleton s2 = Singleton.getInstance();
			Singleton s3 = Singleton.getInstance();
			
			s1.display(); 
			s2.display();

			System.out.println(s1 == s3); 
		} 
	}
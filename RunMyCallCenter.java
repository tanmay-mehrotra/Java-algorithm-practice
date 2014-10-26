package Random;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

abstract class Employee {
	String address;
	String name;
	String empId;
	boolean free = true;
	int empLevel = 1; //default level is 1

	public int getEmpLevel(){
		return empLevel;
	}
	public abstract boolean isfree();
	public abstract void acceptCall(Caller caller);
}


class Caller{
}

class Respondant extends Employee{
	
	public boolean isfree(){
		if (this.free == true)
			return true;
		else
			return false;
	}

	public void acceptCall(Caller caller){
		for(int i = 0 ; i < 100000000; i++);
		this.free = true;
	}

	@Override
	public int getEmpLevel(){
		return this.empLevel;
	}
}


class Manager extends Employee{

	public boolean isfree(){
		if (this.free == true)
			return true;
		else
			return false;
	}

	public void acceptCall(Caller caller){
		for(int i = 0 ; i < 100000000; i++);
		this.free = true;
	}

	@Override
	public int getEmpLevel(){
		this.empLevel = 2;
		return this.empLevel;
	}
}


class Director extends Employee{

	public boolean isfree(){
		if (this.free == true)
			return true;
		else
			return false;
	}

	public void acceptCall(Caller caller){
		for(int i = 0 ; i < 100000000; i++);
		this.free = true;
	}

	@Override
	public int getEmpLevel(){
		this.empLevel = 3;
		return this.empLevel;
	}
}


class CallCenter {

	//declare no. of employees of each type working in this Call center
	Respondant respondants[] = new Respondant[10];
	Manager managers[] = new Manager[5];
	Director directors[] = new Director[2];
	Queue<Caller> queueForCallers = new LinkedList<Caller>();
	Map<Integer,Employee[]> levelEmployeeMap = new HashMap<Integer,Employee[]>();
	int noOfLevels = 3;

	
	public CallCenter(){
		//init level map
		levelEmployeeMap.put(1, respondants);
		levelEmployeeMap.put(2, managers);
		levelEmployeeMap.put(3, directors);
		
		//create employees and put then in arrays 
		for(int i = 0; i < respondants.length;i++){
			respondants[i] = new Respondant();
		}
		
		for(int i = 0; i < managers.length;i++){
			managers[i] = new Manager();
		}
		
		for(int i = 0; i < respondants.length;i++){
			respondants[i] = new Respondant();
		}
	}
	
	/*this method takes a call from the caller and then dispatches it
	 *to the appropriate employee based on the level. If all of them 
	 *are busy we will queue the Caller */
	 public boolean dispatchCall(Caller caller){
		for (int i = 1; i <= noOfLevels; i++){
			Employee[] handler = levelEmployeeMap.get(i);
			for (int j = 0; j < handler.length; j++){
				if(handler[j].isfree()){
					handler[j].acceptCall(caller);
					handler[j].free = false;
					return true;
				}
				if(i==1){
					System.out.println("all Respondents are busy ");
				}
			}
		}
		//all levels tried but unable to dispatch the call
		return queueForCallers.add(caller);
	}
}


public class RunMyCallCenter{
	public static void main(String args[]){
		//creating 15 callers and dispacting their calls
		CallCenter cc = new CallCenter();
		for(int i = 0 ; i < 15; i++ ){
			cc.dispatchCall(new Caller());
		}
	}
}


package Random;

class KleenAndDotOperator {
	public static void main(String[] args) {
		KleenAndDotOperator s = new KleenAndDotOperator();
		System.out.println(s.is_match("za*","za"));
	}

	public boolean is_match(String pattern, String sample){
		return is_match(pattern, sample,0,0);
	}

	boolean is_match(String pattern, String sample, int p, int s){

		while(p<pattern.length() && s<sample.length()){
			if(pattern.charAt(p) == '.'){
				p++;s++;
			}else if(pattern.charAt(p) != '.' && pattern.charAt(p) != '*'){
				//if it is character or a digit
				if(pattern.charAt(p) != sample.charAt(s)){
					return false;
				}else{
					p++;s++;
				}
			}else{//must be kleen operator
				//check if */series of * is/are the last char/chars in pattern
				if(p == pattern.length()-1 || allKleenOperators(pattern, p)){
					return true;
				}else{
					//look for character next to * in the sample string
					for(int i = s; i < sample.length(); i++){
						if(pattern.charAt(p+1) == '.'){//lookahead for next symbol
							p++;
							if(i == sample.length()-1){
								return true;
							}
						}else {
							if(pattern.charAt(p+1) == '*' || pattern.charAt(p+1) == sample.charAt(i)){
								boolean result = is_match(pattern, sample, p+1,i);
								if(result){
									return true;
								}
							}
						}
					}//for loop ends			
					return false;
				}
			}
		}

		if(p == pattern.length() && s == sample.length()){
			//if both pattern and sample are exhausted then its a match
			return true;
		}else if(allKleenOperators(pattern, p) && s == sample.length()){
			return true;
		}else{
			return false;
		}
	}
	
	public boolean allKleenOperators(String pattern, int p){
		for(int i = p ; i < pattern.length(); i++){
			if(pattern.charAt(i)!='*'){
				return false;
			}
		}
		return true;
	}
}

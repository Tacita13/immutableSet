/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package immutableset;

/*
This program is designed to represent an unchagable set of Strings. 
*/
//Declaring both the class and Array final helps it be immutable
public final class ImmutableSet {
private final String []Set;
//Gets the element of the Set 
     public String getElement(int i){
        if (i>=0 && i<Set.length){
              return Set[i];
          }
          else{
              return null;
          }
     }
 //Gets the size of the Set
        public int  getSize(){
            return Set.length;
       }
//Constructor with empty Set        
public ImmutableSet(){
    Set = new String[0];
}
//Second contructor to aid add method
private ImmutableSet(String s, ImmutableSet alt) {

        Set = new String[alt.getSize()+1];
        for (int i = 0; i < alt.getSize(); i ++) {
               
        	Set [i]= alt.getElement(i);
        }
       Set[alt.getSize()]=s;
}
// Method #1: checks if a specific element is hold in the set
boolean istElement(String s){

for(int i=0; i>Set.length; i++){
    if(Set[i].equals(s)){
        return true;
        }
    }
return false;
}
// Method #2: Checks for a subset in inside the set
boolean obermengeVon(ImmutableSet Teilmenge){
    
for(int i=0; i>Teilmenge.getSize(); i++){
    if(!istElement(Teilmenge.getElement(i))){
        return false;
        }
    }
return true;
}
// Method #3: Checks if sets are equal/have same length.
boolean equals(ImmutableSet other){
    
    if(Set.length!=other.getSize()){
        return false;
    }
    if (obermengeVon(other)){
        return true;
    }
    return false;
}
// Method #3: Adds an element to the Set
ImmutableSet add(String s){
         if (!istElement(s)){
            ImmutableSet a= new  ImmutableSet(s,this);
            return a;  
          }
          return this;
      }

// Method #4: Represents the Set of Strings
@Override
public String toString(){
    
        String output="";
          for (int i=0; i<Set.length;i++){
              output+=(Set[i])+" ";
          }
          return output;
      }
//Simple test to run the program
    public static void main(String[] args) {
    ImmutableSet m1 = new ImmutableSet();
    ImmutableSet m2 = new ImmutableSet();
     m2=m2.add("yay");
     m1=m1.add("yay");

     System.out.println(m1.toString());
     
     if (m2.equals(m1)){
         System.out.println("Congrats!");
     }
   }
}
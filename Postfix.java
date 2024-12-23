public class Postfix {
    int maxsize;
    int tos;
    int[]stack;

    public Postfix(){
        maxsize=5;
        tos=-1;
        stack=new int[maxsize];
      }

      public void Push(int data){
        if(tos==maxsize-1){
            System.out.println("Stack is full");

        }
        else{
            tos=tos+1;
            stack[tos]=data;
        }
        

      }

      public int Pop(){
        if(tos==-1){
            System.out.println("Stack is underflow");
            return 0;
            }
            else{
               int data=stack[tos];
                    tos=tos-1;
                    return data;
            }
      }
 public static void main(String[] args) {
    Postfix pst=new Postfix();
    String exp="24+3-";
    int len=exp.length();

     for(int i=0;i<len;i++){
        char ch = exp.charAt(i);
        if(Character.isDigit(ch)){
            pst.Push(ch-'0');
        }

        else if(ch=='+'||ch=='*'||ch=='/'){
            int operand2=pst.Pop();
            int operand1=pst.Pop();
            int result=0;

            switch(ch){
                case '+': 
                result=operand1+operand2;
                break;
                 
                case '/':
                result=operand1/operand2;
                break;

                case '*':
                result=operand1*operand2;
                break;

                case '-':
                result=operand1-operand2;
                break;
                
                default :
                System.out.println("Invalid");
                break;
            }
            pst.Push(result);
        }}


     System.out.println("Final expression is:"+ pst.Pop());

    
    }}


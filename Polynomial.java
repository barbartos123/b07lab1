import javax.swing.plaf.TreeUI;

public class Polynomial
{
    private double[] coefficients;//储存那吃些polinomial 的数组

    public Polynomial() 
    {
        this.coefficients = new double[]{0};//先让这个class的coefficient初始化
    }

    public Polynomial(double[] coefficients) 
    {
        if (coefficients == null || coefficients.length == 0) //如果发现传进去的还是空      
            this.coefficients = new double[]{0};//当前函数的数组也为0
         else 
            this.coefficients = coefficients.clone();//如果不是当前函数coefficient复制
    }

    public Polynomial add(Polynomial other) 
    {
        if(other == null)//如果要加的函数是空的  
            return new Polynomial(this.coefficients.clone());
        
        //接着我们找出谁的长度更长来确认array的长度
        int maxLength = Math.max(this.coefficients.length,other.coefficients.length);

        double[] result = new double[maxLength];

        for(int i=0; i<maxLength; i++)
        {
            double thisCo;
            double otherCo; 

            //如果超出他原本长度就说明没有了没有了就是0
            if(i<this.coefficients.length)
                thisCo = this.coefficients[i];
            else
                thisCo = 0;

            if(i<other.coefficients.length)
                otherCo = other.coefficients[i];
            else
                otherCo = 0;
            
            result[i] = thisCo + otherCo;//在这个位置的数相加并储存到数组里去
        }

        return new Polynomial(result);
    }

    public double evaluate(double x)
    {
        double result = 0;
        for (int i = 0; i < coefficients.length; i++) 
        {
            result += coefficients[i] * Math.pow(x, i);
        }
        return result;
    }

    public boolean hasRoot(double x)
    {
      if(evaluate(x) == 0)
        return true;
    else
        return false;
    }
}
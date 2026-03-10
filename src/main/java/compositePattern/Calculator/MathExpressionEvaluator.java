package compositePattern.Calculator;

public class MathExpressionEvaluator {
    public static void main (String[] args) {
        System.out.println("===================== Composite Design Pattern===============");
        //2*(1+7) tree structure of evaluation

        ArithmaticExpression two = new Number(2);
        ArithmaticExpression one = new  Number(1);
        ArithmaticExpression seven = new Number(7);

        ArithmaticExpression addExpression = new Expression(one, seven, OperationType.ADD);
        ArithmaticExpression parentExpression = new Expression(two, addExpression, OperationType.MULTIPLY);
        System.out.println(parentExpression.evaluate());
    }
}

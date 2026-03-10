package compositePattern.Calculator;

public class Expression implements ArithmaticExpression{

    ArithmaticExpression leftExpression;
    ArithmaticExpression rightExpression;
    OperationType operation;

    public Expression(ArithmaticExpression leftPart, ArithmaticExpression rightPart, OperationType operation) {
        this.leftExpression = leftPart;
        this.rightExpression = rightPart;
        this.operation = operation;
    }
    @Override
    public int evaluate() {
        int value =0;
        switch (operation) {
            case OperationType.ADD :
                value = leftExpression.evaluate() + rightExpression.evaluate();
                break;
            case OperationType.SUBTRACT:
                value = leftExpression.evaluate()-rightExpression.evaluate();
                break;
            case OperationType.DIVISION:
                value = leftExpression.evaluate()/rightExpression.evaluate();
                break;
            case OperationType.MULTIPLY:
                value = leftExpression.evaluate() * rightExpression.evaluate();
                break;
        }
        System.out.println("Expression value is: "+value);
        return value;
    }
}

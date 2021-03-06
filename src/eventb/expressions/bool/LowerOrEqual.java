package eventb.expressions.bool;

import eventb.expressions.AExpression;
import eventb.expressions.IBinaryOperation;
import eventb.expressions.arith.AArithmeticExpression;
import eventb.expressions.arith.AAssignable;
import eventb.tools.formatters.IEventBFormatter;
import eventb.tools.formatters.IExpressionFormatter;
import eventb.tools.primer.IExpressionToExpressionVisitor;
import eventb.tools.replacer.IAssignableReplacer;

import java.util.LinkedHashSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by gvoiron on 07/07/16.
 * Time : 23:23
 */
public final class LowerOrEqual extends ABooleanExpression implements IBinaryOperation {

    private final AArithmeticExpression left;
    private final AArithmeticExpression right;

    public LowerOrEqual(AArithmeticExpression left, AArithmeticExpression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public String accept(IEventBFormatter visitor) {
        return visitor.visit(this);
    }

    @Override
    public AExpression accept(IAssignableReplacer visitor) {
        return visitor.visit(this);
    }

    @Override
    public String accept(IExpressionFormatter visitor) {
        return visitor.visit(this);
    }

    @Override
    public AExpression accept(IExpressionToExpressionVisitor visitor) {
        return visitor.visit(this);
    }

    @Override
    public AArithmeticExpression getLeft() {
        return left;
    }

    @Override
    public AArithmeticExpression getRight() {
        return right;
    }

    @Override
    public LinkedHashSet<AAssignable> getAssignables() {
        return new LinkedHashSet<>(Stream.concat(getLeft().getAssignables().stream(), getRight().getAssignables().stream()).collect(Collectors.toList()));
    }

}

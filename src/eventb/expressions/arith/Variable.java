package eventb.expressions.arith;

import eventb.expressions.AExpression;
import eventb.tools.formatters.IEventBFormatter;
import eventb.tools.formatters.IExpressionFormatter;
import eventb.tools.primer.IExpressionToExpressionVisitor;
import eventb.tools.replacer.IAssignableReplacer;

import java.util.Collections;
import java.util.LinkedHashSet;

/**
 * Created by gvoiron on 07/07/16.
 * Time : 10:45
 */
public final class Variable extends AAssignable {

    private String name;

    public Variable(String name) {
        this.name = name;
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

    public String getName() {
        return name;
    }

    @Override
    public LinkedHashSet<AAssignable> getAssignables() {
        return new LinkedHashSet<>(Collections.singletonList(this));
    }

}

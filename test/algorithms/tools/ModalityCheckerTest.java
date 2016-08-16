package algorithms.tools;

import eventb.Event;
import eventb.Machine;
import eventb.expressions.arith.Int;
import eventb.expressions.arith.Variable;
import eventb.expressions.bool.*;
import eventb.parsers.EBMParser;
import graphs.AbstractState;
import graphs.AbstractTransition;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.util.stream.Collectors;

/**
 * Created by gvoiron on 15/08/16.
 * Time : 18:30
 */
@SuppressWarnings("unchecked")
public class ModalityCheckerTest {

    @Test
    public void isMay() throws Exception {
        Machine machine = (Machine) new EBMParser().parse(new File("resources/eventb/threeBatteries/threeBatteries.ebm"));
        Int zero = new Int(0);
        Variable h = new Variable("h");
        Variable bat1 = new Variable("bat1");
        Variable bat2 = new Variable("bat2");
        Variable bat3 = new Variable("bat3");
        Predicate p0 = new Predicate("p0", new Equals(h, zero));
        Predicate p1 = new Predicate("p1", new Or(new And(new Equals(bat1, zero), new Equals(bat2, zero)), new And(new Equals(bat2, zero), new Equals(bat3, zero)), new And(new Equals(bat1, zero), new Equals(bat3, zero))));
        ModalityChecker modalityChecker = new ModalityChecker(machine);
        AbstractState q0 = new AbstractState("q0", new And(new Not(p0), new Not(p1)));
        AbstractState q1 = new AbstractState("q1", new And(new Not(p0), p1));
        AbstractState q2 = new AbstractState("q2", new And(p0, new Not(p1)));
        AbstractState q3 = new AbstractState("q3", new And(p0, p1));
        Event tic = machine.getEvents().stream().filter(event -> event.getName().equals("Tic")).collect(Collectors.toList()).get(0);
        Event commute = machine.getEvents().stream().filter(event -> event.getName().equals("Commute")).collect(Collectors.toList()).get(0);
        Event repair = machine.getEvents().stream().filter(event -> event.getName().equals("Repair")).collect(Collectors.toList()).get(0);
        Event fail = machine.getEvents().stream().filter(event -> event.getName().equals("Fail")).collect(Collectors.toList()).get(0);
        Assert.assertTrue(modalityChecker.isMay(new AbstractTransition(q0, tic, q2)));
        Assert.assertTrue(modalityChecker.isMay(new AbstractTransition(q0, repair, q1)));
        Assert.assertTrue(modalityChecker.isMay(new AbstractTransition(q1, tic, q3)));
        Assert.assertTrue(modalityChecker.isMay(new AbstractTransition(q1, repair, q1)));
        Assert.assertTrue(modalityChecker.isMay(new AbstractTransition(q1, fail, q0)));
        Assert.assertTrue(modalityChecker.isMay(new AbstractTransition(q1, fail, q1)));
        Assert.assertTrue(modalityChecker.isMay(new AbstractTransition(q2, repair, q3)));
        Assert.assertTrue(modalityChecker.isMay(new AbstractTransition(q3, commute, q1)));
        Assert.assertTrue(modalityChecker.isMay(new AbstractTransition(q3, repair, q3)));
        Assert.assertTrue(modalityChecker.isMay(new AbstractTransition(q3, fail, q2)));
        Assert.assertTrue(modalityChecker.isMay(new AbstractTransition(q3, fail, q3)));
        Assert.assertFalse(modalityChecker.isMay(new AbstractTransition(q0, tic, q0)));
        Assert.assertFalse(modalityChecker.isMay(new AbstractTransition(q0, tic, q1)));
        Assert.assertFalse(modalityChecker.isMay(new AbstractTransition(q0, tic, q3)));
        Assert.assertFalse(modalityChecker.isMay(new AbstractTransition(q0, commute, q0)));
        Assert.assertFalse(modalityChecker.isMay(new AbstractTransition(q0, commute, q1)));
        Assert.assertFalse(modalityChecker.isMay(new AbstractTransition(q0, commute, q2)));
        Assert.assertFalse(modalityChecker.isMay(new AbstractTransition(q0, commute, q3)));
        Assert.assertFalse(modalityChecker.isMay(new AbstractTransition(q0, repair, q0)));
        Assert.assertFalse(modalityChecker.isMay(new AbstractTransition(q0, repair, q2)));
        Assert.assertFalse(modalityChecker.isMay(new AbstractTransition(q0, repair, q3)));
        Assert.assertFalse(modalityChecker.isMay(new AbstractTransition(q1, tic, q0)));
        Assert.assertFalse(modalityChecker.isMay(new AbstractTransition(q1, tic, q1)));
        Assert.assertFalse(modalityChecker.isMay(new AbstractTransition(q1, tic, q2)));
        Assert.assertFalse(modalityChecker.isMay(new AbstractTransition(q1, commute, q0)));
        Assert.assertFalse(modalityChecker.isMay(new AbstractTransition(q1, commute, q1)));
        Assert.assertFalse(modalityChecker.isMay(new AbstractTransition(q1, commute, q2)));
        Assert.assertFalse(modalityChecker.isMay(new AbstractTransition(q1, commute, q3)));
        Assert.assertFalse(modalityChecker.isMay(new AbstractTransition(q1, repair, q0)));
        Assert.assertFalse(modalityChecker.isMay(new AbstractTransition(q1, repair, q2)));
        Assert.assertFalse(modalityChecker.isMay(new AbstractTransition(q1, repair, q3)));
        Assert.assertFalse(modalityChecker.isMay(new AbstractTransition(q1, fail, q2)));
        Assert.assertFalse(modalityChecker.isMay(new AbstractTransition(q1, fail, q3)));
        Assert.assertFalse(modalityChecker.isMay(new AbstractTransition(q2, tic, q0)));
        Assert.assertFalse(modalityChecker.isMay(new AbstractTransition(q2, tic, q1)));
        Assert.assertFalse(modalityChecker.isMay(new AbstractTransition(q2, tic, q2)));
        Assert.assertFalse(modalityChecker.isMay(new AbstractTransition(q2, tic, q3)));
        Assert.assertFalse(modalityChecker.isMay(new AbstractTransition(q2, commute, q0)));
        Assert.assertFalse(modalityChecker.isMay(new AbstractTransition(q2, commute, q1)));
        Assert.assertFalse(modalityChecker.isMay(new AbstractTransition(q2, commute, q2)));
        Assert.assertFalse(modalityChecker.isMay(new AbstractTransition(q2, commute, q3)));
        Assert.assertFalse(modalityChecker.isMay(new AbstractTransition(q2, repair, q0)));
        Assert.assertFalse(modalityChecker.isMay(new AbstractTransition(q2, repair, q1)));
        Assert.assertFalse(modalityChecker.isMay(new AbstractTransition(q2, repair, q2)));
        Assert.assertFalse(modalityChecker.isMay(new AbstractTransition(q2, fail, q0)));
        Assert.assertFalse(modalityChecker.isMay(new AbstractTransition(q2, fail, q1)));
        Assert.assertFalse(modalityChecker.isMay(new AbstractTransition(q2, fail, q2)));
        Assert.assertFalse(modalityChecker.isMay(new AbstractTransition(q2, fail, q3)));
        Assert.assertFalse(modalityChecker.isMay(new AbstractTransition(q3, tic, q0)));
        Assert.assertFalse(modalityChecker.isMay(new AbstractTransition(q3, tic, q1)));
        Assert.assertFalse(modalityChecker.isMay(new AbstractTransition(q3, tic, q2)));
        Assert.assertFalse(modalityChecker.isMay(new AbstractTransition(q3, tic, q3)));
        Assert.assertFalse(modalityChecker.isMay(new AbstractTransition(q3, commute, q0)));
        Assert.assertFalse(modalityChecker.isMay(new AbstractTransition(q3, commute, q2)));
        Assert.assertFalse(modalityChecker.isMay(new AbstractTransition(q3, commute, q3)));
        Assert.assertFalse(modalityChecker.isMay(new AbstractTransition(q3, repair, q0)));
        Assert.assertFalse(modalityChecker.isMay(new AbstractTransition(q3, repair, q1)));
        Assert.assertFalse(modalityChecker.isMay(new AbstractTransition(q3, repair, q2)));
        Assert.assertFalse(modalityChecker.isMay(new AbstractTransition(q3, fail, q0)));
        Assert.assertFalse(modalityChecker.isMay(new AbstractTransition(q3, fail, q1)));
    }

    @Test
    public void getMachine() throws Exception {
        Machine machine = (Machine) new EBMParser().parse(new File("resources/eventb/threeBatteries/threeBatteries.ebm"));
        ModalityChecker modalityChecker = new ModalityChecker(machine);
        Assert.assertEquals(machine, modalityChecker.getMachine());
    }

}
package ru.job4j.chess.firuges.black;

import org.junit.Assert;
import org.junit.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import static org.hamcrest.core.Is.is;

public class BishopBlackTest {

    @Test
    public void whenCreateOnBOneThenPositionBOne() {
        Cell position = Cell.B1;
        BishopBlack bishopBlack = new BishopBlack(position);
        Cell expectedPosition = Cell.B1;
        Assert.assertThat(expectedPosition, is(bishopBlack.position()));
    }

    @Test
    public void whenCopyToEFourThenPossitionEFour() {
        Cell startPosition = Cell.B1;
        Cell destPosition = Cell.E4;
        Figure bishopBlack = new BishopBlack(startPosition);
        Figure nextBishopBlack = bishopBlack.copy(destPosition);
        Cell expectedPosition = Cell.E4;
        Assert.assertThat(expectedPosition, is(nextBishopBlack.position()));
    }

    @Test
    public void whenWayFromCOneToGFive() {
        Figure bishopeBlack = new BishopBlack(Cell.C1);
        Cell[] cells = bishopeBlack.way(Cell.G5);
        Cell[] expectedCells = {
                Cell.D2, Cell.E3, Cell.F4, Cell.G5
        };
        Assert.assertThat(expectedCells, is(cells));
    }

    @Test(expected = ImpossibleMoveException.class)
    public void whenMoveNotOnDiagonal() {
        Figure bishopeBlack = new BishopBlack(Cell.C1);
        bishopeBlack.way(Cell.F2);
    }

    @Test
    public void whenCellsOnDiagonal() {
        Cell source = Cell.B1;
        Cell dest = Cell.E4;
        boolean rst = new BishopBlack(source).isDiagonal(source, dest);
        Assert.assertTrue(rst);
    }
}
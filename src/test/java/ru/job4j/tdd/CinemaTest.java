package ru.job4j.tdd;

import org.junit.Ignore;
import org.junit.Test;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class CinemaTest {

    @Ignore
    @Test
    public void whenBuy() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        date.set(2020, Calendar.DECEMBER, 10, 23, 0);
        Ticket ticket = cinema.buy(account, 1, 1, date);
        assertThat(ticket, is(new Ticket3D()));
    }

    @Ignore
    @Test
    public void whenFind() {
        Cinema cinema = new Cinema3D();
        cinema.add(new Session3D());
        List<Session> sessions = cinema.find(session -> true);
        assertThat(sessions, is(Arrays.asList(new Session3D())));
    }

    @Ignore
    @Test
    public void whenCanNotBuy() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        date.set(2020, Calendar.NOVEMBER, 10, 23, 0);
        Ticket ticket = cinema.buy(account, 1, 1, date);
        assertThat(ticket, is(new Ticket3D()));
    }

    @Ignore
    @Test
    public void whenCanNotFind() {
        Cinema cinema = new Cinema3D();
        List<Session> sessions = cinema.find(session -> false);
        assertThat(sessions, is(Arrays.asList(new Session3D())));
    }
/*
1) невалидное место
 */
    @Ignore
    @Test(expected = IllegalArgumentException.class)
    public void whenInvalidPlace() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        date.set(2022, Calendar.JUNE, 17, 20, 0);
        Ticket ticket = cinema.buy(account, 50, 100, date);
    }

    /*
    2) невалидная дата
     */
    @Ignore
    @Test(expected = IllegalArgumentException.class)
    public void whenInvalidDate() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        date.set(2000, Calendar.JUNE, 17, 20, 0);
        Ticket ticket = cinema.buy(account, 50, 100, date);
    }

    /*
    3) покупка билета, на уже выкупленное место.
    покупка этого же билета другим пользователем
     */
    @Ignore
    @Test(expected = IllegalArgumentException.class)
    public void whenBuyTicketSeatOccupied() {
        Account account = new AccountCinema();
        Account anotherAccount = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        date.set(2020, Calendar.DECEMBER, 10, 23, 0);
        Ticket ticket = cinema.buy(account, 1, 1, date);
        Ticket occupiedTicket = cinema.buy(anotherAccount, 1, 1, date);
    }
}


package co.com.choucair.automation.android.tasks;



import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.choucair.automation.android.userinterfaces.LoginPage.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;

public class Login implements Task {
    private String user;
    private String password;
    public Login(String user, String password) {
        this.user = user;
        this.password = password;
    }
    public static Login with(String user, String password) {
        return Tasks.instrumented(Login.class, user, password);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(user).into(EMAIL_INPUT),
                Click.on(EMAIL_BUTTON),
                Click.on(PASSWORD_LINK),
                Enter.theValue(password).into(PASSWORD_INPUT),
                Click.on(PASSWORD_BUTTON),
                WaitUntil.the(TEXT_LABEL,isPresent()).forNoMoreThan( 10).seconds()
        );

    }
}

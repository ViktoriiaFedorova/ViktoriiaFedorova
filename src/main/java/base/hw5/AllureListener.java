package base.hw5;

import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.LogEvent;
import com.codeborne.selenide.logevents.LogEventListener;
import io.qameta.allure.Allure;
import io.qameta.allure.AllureLifecycle;
import io.qameta.allure.model.Status;
import io.qameta.allure.model.StatusDetails;
import io.qameta.allure.util.ResultsUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.nio.charset.StandardCharsets;
import java.util.UUID;

public class AllureListener implements LogEventListener {

    private final AllureLifecycle lifecycle;

    public AllureListener() {
        this(Allure.getLifecycle());
    }

    public AllureListener(final AllureLifecycle lifecycle) {
        this.lifecycle = lifecycle;
    }

    @Override
    public void onEvent(final LogEvent event) {
        lifecycle.getCurrentTestCase().ifPresent(uuid -> {
            final String stepUUID = UUID.randomUUID().toString();

            if (LogEvent.EventStatus.FAIL.equals(event.getStatus())) {
                lifecycle.addAttachment("Screenshot", "image/png", "png", getScreenshotBytes());
                lifecycle.addAttachment("Page source", "text/html", "html", getPageSourceBytes());
                lifecycle.updateStep(stepResult -> {
                    final StatusDetails details = ResultsUtils.getStatusDetails(event.getError())
                            .orElse(new StatusDetails());
                    stepResult.setStatus(Status.FAILED);
                    stepResult.setStatusDetails(details);
                });
            }
            lifecycle.stopStep(stepUUID);
        });
    }

    private static byte[] getScreenshotBytes() {
        return WebDriverRunner.hasWebDriverStarted() ?
                ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES)
                : new byte[0];
    }

    private static byte[] getPageSourceBytes() {
        return WebDriverRunner.hasWebDriverStarted() ?
                ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES)
                : new byte[0];
    }

}

package common;

import api.BaseConfig.ServicesAll;
import lombok.extern.slf4j.Slf4j;
import org.testng.IHookCallBack;
import org.testng.IHookable;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.io.IOException;
import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.UUID;


@Slf4j
public class AbstractTest implements IHookable {

    private ThreadLocal<ServicesAll> api = new ThreadLocal<>();


    @BeforeMethod(alwaysRun = true)
    public void beforeMethod(Method method, Object[] objects) throws IOException {
        UUID corrId = UUID.randomUUID();
        log.info("Start of test:#: {} , ThreadId: {} , CORR_ID: {}", method.getName(), Thread.currentThread().getId(), corrId);
        String methodName = method.getName();
        String startTime = String.valueOf(new Timestamp(System.currentTimeMillis()).getTime());
        if (objects != null && objects.length != 0) {
            methodName = String.format("%s_withParameters_%s", method.getName(), startTime);
        }
    }

    @AfterMethod(alwaysRun = true)
    public final void afterMethod(final ITestResult testResult) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(testResult.getStartMillis());
        api.remove();

    }

    public ServicesAll api() {
        if (api.get() == null) {
            api = ThreadLocal.withInitial(ServicesAll::new);
        }
        return api.get();
    }

    @Override
    public void run(IHookCallBack callBack, ITestResult iTestResult) {
        callBack.runTestMethod(iTestResult);
    }
}

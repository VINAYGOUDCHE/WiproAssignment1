package com.springlab8.SpringLab8;

public class LoggingAspect {

    public void logBefore() {
        System.out.println("📌 [Before] Method execution starting...");
    }

    public void logAfterReturning() {
        System.out.println("✅ [AfterReturning] Method executed successfully.");
    }

    public void logAfterThrowing() {
        System.out.println("⚠️ [AfterThrowing] Exception occurred during method execution.");
    }
}
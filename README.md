# FB Login Automate - Selenium Java Automation Project with Extent Report

## Introduction

This project is a Selenium automation framework built in Java, utilizing the Maven build tool. It is designed for web application testing and includes the Extent Report library for comprehensive test reporting.

## Prerequisites

- Java SDK (version 1.8.0_202)
- Maven
- WebDriver (Chrome driver) 

### ChromeDriver

Download the appropriate version of ChromeDriver based on your Chrome browser version from [ChromeDriver Downloads](https://chromedriver.chromium.org/downloads).

## Getting Started

1. **Clone the repository:**

    ```bash
    git clone https://github.com/yourusername/your-repository.git
    cd your-repository
    ```

2. **Install dependencies:**

    ```bash
    mvn clean install
    ```

## Running Tests

Ensure you have ChromeDriver downloaded and available in your system PATH.

System.setProperty("webdriver.chrome.driver", "ADD CHROMEDRIVER INSTALLED PATH HERE");

Run Testsuite avalialbe in testng.xml file or Run diirectly Test class

## After runs automatically download the relevent testcase resuLts as HTML report - Download it from project location or Relevent enviroment

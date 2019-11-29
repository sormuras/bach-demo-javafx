# 📋 Minimal modular Java project template using Bach.java

This template repository only contains a few project-related files:

- **`build.yml`** in `.github/workflows`
  ```yml
  name: build
  on: push
  jobs:
    build:
      runs-on: ubuntu-latest
      steps:
      - uses: actions/checkout@v1
      - name: Set up JDK
        uses: actions/setup-java@v1
        with:
          java-version: 11
      - name: Build with Bach.java
        run: jshell https://bit.ly/bach-jsh
  ```
- **`module-info.java`** in `src/com.github.sormuras.bach.template/main/java`
  ```java
  module com.github.sormuras.bach.template {}
  ```

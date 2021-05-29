# Serve

Build A Sample File Server With GraalVM Native Image

### Export Java Home

```sh
export JAVA_HOME=/path/to/GRAALVM_HOME
```

### Build Native Image

```sh
./gradlew buildNative
```

### Start Serving

```sh
./app/build/libs/app
```

Visit http://localhost:8080/

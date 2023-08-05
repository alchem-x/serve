# Serve

Build A Simple File Server With GraalVM Native Image

### Export GraalVM Home

```sh
export GRAALVM_HOME=/path/to/GRAALVM_HOME
```

### Build Native Image

```sh
./gradlew :serve:nativeBuild
```

### Start Serving

```sh
./serve/build/libs/serve 8080
```

Visit http://localhost:8080/

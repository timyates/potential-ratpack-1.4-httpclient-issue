> A proxy a' both your endpoints! I am sped.
>
> Is he gone and hath nothing?

Run with

```
./gradlew run
```

Then (assuming the dropwizard app is also running), there will be 4 valid endpoints:

### Using the Unpooled HttpClient

- http://localhost:5050/default/small
- http://localhost:5050/default/big

### Using the Pooled HttpClient

- http://localhost:5050/pooled/small
- http://localhost:5050/pooled/big


You should see that `default/big` never finishes in Chrome...
### Scanner to array
###### Input: N, A0, A1, ..., A(N-1)
```Java
int[] arr = IntStream
        .generate(scn::nextInt)
        .limit(scn.nextInt()) // This is required.
        .toArray();
```

### Sum of Array
###### Note: Works with any IntStream, LongStream, or DoubleStream
```Java
Arrays.stream(arr).sum(); // >> 10
```

### Stream to String
###### Note: Read up on java.util.stream.Collectors!
```Java
stream.collect(Collectors.joining(", ", "[", "]"));
```
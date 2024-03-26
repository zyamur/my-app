# Java Classes and Unit Tests

This repository contains two Java classes along with their corresponding unit test classes.

## Classes

### Compute

The `Compute` class provides methods to perform computations on a `MessageQueue`.

#### Methods

- `countNumberOfOccurrences(String e)`

### Util

The `Util` class provides a method to compute a boolean value based on the sum of input arguments.

#### Methods

- `compute(int... args)`

## Unit Test Classes

### TestCompute

The `TestCompute` class contains unit tests for the `Compute` class.

#### Test Cases

- `testEmptyQueue`
- `testStringNotInTheQueue`
- `testStringInTheQueue`
- `testStringInTheQueueNotEqualToGivenString`

### TestUtil

The `TestUtil` class contains unit tests for the `Util` class.

#### Test Cases

- `testOneArgument`
- `testEvenNumberArguments`
- `testArgumentIsZero`
- `testSumDivisibleByArgument`
- `testNoConditionSatisfied`


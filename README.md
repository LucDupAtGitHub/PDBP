# Program Description Based Programming

## Introduction

When writing an introduction it is challenging to find the right balance between providing *too many details* or *too few details*. This introduction provides many details. It is perfectly fine to read it diagonally.

Before starting, let's present a bit of history.

### History

In 1977, John Backus was an [ACM A.M. Turing Award](http://amturing.acm.org/) winner. The title of his Turing Award winning lecture was 

*Can programming be liberated from the von Neumann style? A functional style and it's algebra of programs.*

This documentation builds upon the ideas of this influential lecture.


### `FP`

In his Turing Award winning lecture, John Backus describes a [*function level programming language* `FP`](https://en.wikipedia.org/wiki/FP_%28programming_language). 

The `FP` programming language consists of *objects*, *programs*, *forms* and *definitions*, where

 - A program transforms objects to an object.
 - A form transforms programs to a program.
 - A definition defines a program or a form in terms of programs and forms.

The `FP` forms are 

 - *Function*
 - *Composition*
 - *Construction*
 - *Condition*
 - *Aggreation*

`FP` does not really have an aggregation form. It does have objects that are *sequences* of objects. We included aggregation since it consists of, somehow, reducing objects of a structure of objects (for example a sequence of objects) to a single object.

### `Dotty`

In this documentation, we describe a *program description library* that is written in the [`Dotty` *programming language*](http://dotty.epfl.ch/). The main `trait` of the library is the `Program` *type class* that closely resembles `FP`.

Below is the logo of the library

```scala
    //       _______         __    __        _______
    //      / ___  /\       / /\  / /\      / ___  /\
    //     / /__/ / / _____/ / / / /_/__   / /__/ / /
    //    / _____/ / / ___  / / / ___  /\ /____  / /
    //   / /\____\/ / /__/ / / / /__/ / / \___/ / /
    //  /_/ /      /______/ / /______/ /     /_/ /
    //  \_\/       \______\/  \______\/      \_\/
    //                                           v1.0
    //  Program Description Based Programming Library
    //  author        Luc Duponcheel        2017-2018
```

### Mapping from `FP` to `Dotty`

Consider

```scala
trait Program[>-->[- _, + _]]
    extends Function[>-->]
    with Composition[>-->]
    with Construction[>-->]
    with Condition[>-->]
    with Aggregation[>-->]
    with Execution[>-->]
```

The `FP` forms map one-to-one to `trait`'s that are mixed-in by `trait Program`. There is an important difference between `FP` programs and `Dotty` program descriptions.

 - `FP` programs are *language* based
 - `Dotty` program descriptions are *library* based 

Therefore

 - in `FP`
   - programs have only *one* meaning
   - forms cannot be extended
 - in `Dotty`
   - programs can have *many* meanings (cfr. `trait Execution`)
   - `trait Program` can be extended

Exploiting the flexibility that comes with those differences is one of the most important themes of this documentation. 

For example:

 - One and the same program description for, say, `factorial` can have both a *non tail recursive* and a *tail recursive* meaning.
 - *extra programming capabilities* can be added such as
   - input reading
   - output writing
   - state manipulation
   - failure handling
   - latency handling (using parallelism)
   - advanced control beyond conditional control
   - ...

Our library is all about *program descriptions*, and, by slight abuse of notation, we are going to simply refer to them as *programs*. In a way programs generalize *functions*. A *function call evaluation* transforms *function arguments* to yield a *function result*. A *program execution* also, *somehow*, transforms *program arguments* to yield a *program result*.
When there is no danger of confusion we are going to use *arguments* and *result*.

Our library is also about *computation descriptions*, and, by slight abuse of notation, we are going to simply refer to them as *computations*. In a way computations generalize *expressions*. An *expression evaluation* yields an *expression result*. A *computation execution* also, *somehow*, yields a *computation result*. When there is no danger of confusion we are going to use *result*.






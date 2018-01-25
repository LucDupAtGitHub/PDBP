# Program Description Based Programming

## Introduction

When writing an introduction it is challenging to find the right balance between providing *too many details* or *too few details*. This introduction provides many details. It is perfectly fine to read it diagonally.

Before starting, let's present a bit of history.

### History

In 1977, John Backus was an [ACM A.M. Turing Award](http://amturing.acm.org/) winner. The title of his Turing Award winning lecture was 

*Can programming be liberated from the von Neumann style? A functional style and it's algebra of programs.*

This project builds upon the ideas of this influential lecture.


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

In this project, we develop a *program description library* that is written in the [`Dotty` *programming language*](http://dotty.epfl.ch/). The main `trait` of the library is the `Program` *type class* that closely resembles `FP`.

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
   - program descriptions can have *many* meanings (cfr. `trait Execution`)
   - `trait Program` can be extended

Exploiting the flexibility that comes with those differences is one of the most important themes of this project. 

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

Our library is all about *program descriptions*, and, by slight abuse of notation, we are going to simply refer to them as *programs*. In a way programs generalize *functions*. A *function call* (*function call expression evaluation*) transforms *function arguments* to yield a *function result*. A *program execution* also, *somehow*, transforms *program arguments* to yield a *program result*. When there is no danger of confusion we are simply going to write *arguments* and *result*.

Our library is also about *computation descriptions*, and, by slight abuse of notation, we are going to simply refer to them as *computations*. In a way computations generalize *expressions*. An *expression evaluation* yields an *expression result*. A *computation execution* also, *somehow*, yields a *computation result*. When there is no danger of confusion we are simply going to write *result*.

### Descriptions

In the previous sections we have mentioned that programs (program descriptions) can have many meanings In this section we present some `Dotty` code to illustrate the difference between a *description* and it's *meaning*. The `Dotty` code does not deal with programming capabilities or computational capabilities at all. Instead it simply deals with *element* related capabilities. Below are some consecutive \ttb{Dotty} REPL (Read-Eval-Print-Loop) sessions

```scala
scala> trait HasElement[M] {
         val element: M
       }   
defined trait HasElement
scala> trait HasFunction[M] {
         def function(m: M): M
       }   
defined trait HasFunction
```

Above are two `Dotty` *type classes* for a type `M` declaring element related capabilities.

 - `trait HasElement[M]` declares `M`s capability to have an element `element`
 - `trait HasFunction[M]` declares `M`'s capability to have an function `function` that transforms an argument `m` to yield an result element `function(m)`

Given those *declarations* we can already start *defining* some *element descriptions* as illustrated below

```scala
scala> trait SomeElement[M : HasElement : HasFunction] {
         val hasFunction = implicitly[HasFunction[M]]
         import hasFunction._
         
         val hasElement = implicitly[HasElement[M]]
         import hasElement._
         
         val someElement = function(element)  
       }   
defined trait SomeElement 
```

The code above defines an element description `someElement` as a `val`.
It is a member of `trait SomeElement[M : HasElement : HasFunction]`, that declares `M` to *implicitly* have the capabilities that are needed to define `someElement`. The element description `someElement` is defined in terms of those capabilities: `element` and `function`. Think of the description as a *recipe* for making some element:

*Take `element` and apply `function` to it to make `someElement`*

At this moment there is *no definition* of the declared capabilities available yet. Let's go ahead and introduce an *implicit definition* of those declared capabilities for the type `Int`:

```scala
scala> implicit object intHasElementAndFunction extends
         HasElement[Int] with HasFunction[Int] {
         
         override val element: Int = 0
         
         override def function(i: Int): Int = i + 1
         
       }   
defined module intHasElementAndFunction
scala> object someIntElement extends SomeElement[Int]() 
defined module someIntElement
scala> import someIntElement._ 
import someIntElement._
```

First, the code above introduces `implicit object intHasElementAndFunction`.
As long as we keep `Dotty`'s type system happy, we have the full flexibility to define `element` and `function` in *any* way we want. Second, the code above makes `someElement`, an element of type `Int` available using a technique, *dependency injection by `import`*, that will be used a lot in this book.For {\em type classes}, dependency injection in `Dotty` is as simple as doing an appropriate `import`. Now that we have *defined* `M` to be `Int`, we write *element*. When `M` was *declared* we wrote *element description*. Rememer that for program descriptions our notation is *not* going to be so precise. Let's go ahead and make use of `someElement`

```scala
scala> someElement 
val res0: Int = 1
```










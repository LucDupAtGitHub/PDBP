// package pdbp.computation

// //       _______         __    __        _______
// //      / ___  /\       / /\  / /\      / ___  /\
// //     / /__/ / / _____/ / / / /_/__   / /__/ / /
// //    / _____/ / / ___  / / / ___  /\ /____  / /
// //   / /\____\/ / /__/ / / / /__/ / / \___/ / /
// //  /_/ /      /______/ / /______/ /     /_/ /
// //  \_\/       \______\/  \______\/      \_\/
// //                                           v1.0
// //  Program Description Based Programming Library
// //  author        Luc Duponcheel        2017-2018

// trait ~>[From[+ _], To[+ _]] {

//   def apply[Z]: From[Z] => To[Z]

// }

// object ~> {

//   def `~i~>`[M[+ _]]: M ~> M = new (M ~> M) {

//     def apply[Z]: M[Z] => M[Z] = mz => mz

//   } 

// }


package codespace.mehakmeet.studybudy;

public enum Timeline {

    D11("Java is a general-purpose computer-programming language that is concurrent, class-based, object-oriented, and specifically designed to have as few implementation dependencies as possible.\n" +
            "It was designed by James Gosling on May 23rd 1995 at Sun Microsystems."),
    D12("Python is an interpreted high-level programming language for general-purpose programming. Created by Guido van Rossum and first released in 1991.\n" +
            "It works on natural language."),
    D13("Hypertext Markup Language is the standard markup language for creating web pages and web applications. With Cascading Style Sheets and JavaScript, it forms a triad of cornerstone technologies for the World Wide Web.\n"),
    D14("Android is a mobile operating system developed by Google, based on a modified version of the Linux kernel and other open source software and designed primarily for touchscreen mobile devices such as smartphones and tablets" +
            "."),
    D21("\n" +
            "Swift is a general-purpose, multi-paradigm, compiled programming language developed by Apple Inc. for iOS, macOS, watchOS, tvOS, and Linux." +
            " Swift is designed to work with Apple's Cocoa and Cocoa Touch frameworks and the large body of existing Objective-C (ObjC) code written for Apple products. It is built with the open source LLVM compiler framework and has been included in Xcode since version 6."),
    D22("JavaScript, often abbreviated as JS, is a high-level, interpreted programming language.\n" +
            " It is a language which is also characterized as dynamic, weakly typed, prototype-based and multi-paradigm.\n"),
    D23("C++ is a general-purpose programming language. It has imperative, object-oriented and generic programming features, while also providing facilities for low-level memory manipulation.\n");
    /*("Don't let hunger get in the way of creating. Catch up on some meal time with your" +
            " breakfast giving you a break from coding."),
    D25("This would be to remind you of the looking deadline, and to finish up on integrating the" +
            " modules you have been working on. Add finishing touches to your project to make it" +
            " stand out."),
    D26("Time's up fellas! End the codes and start the presentations. You now have to finish" +
            " what you started and get working on a pitch to be presented to the judges." +
            " This would be the first call for pitch submission."),
    D27("Time to see what you and your friends did all those 18 hours. Adhere to the deadlines," +
            " the pitching would begin at 2 PM.\n"),
    D28("Get ready to have your curiosity prodded and long standing questions answered." +
            " You're in for a treat!"),
    D29("The results are announced for the winners of the Ideathon and Hackathon, everyone" +
            " collects their schwags and says goodbye to an exciting weekend.");*/

    private String displayName;

    Timeline(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}

# redact

![](https://github.com/sheng168/redact/workflows/Java%20CI/badge.svg)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/us.jsy/redact-jackson/badge.svg)](https://maven-badges.herokuapp.com/maven-central/us.jsy/redact-jackson)

We currently handle PII in a adhoc manner. Knowledge about what is and isn't PII is spread among code reviews, toString implementations of data objects, logger calls that carefully avoid them and etc. New hires often don't have any idea about PII and will log entire data objects. We need to make this nature and default behavior safe. 

We create a small class and subclasses whose main job is to hold PII and override toString to implement the require level of redaction. Additionally this class will be transparent to our Json parser so as to not affect our API data format.

Once this work is done, finding PII in our code base will be a simple matter of locating usage of this class.

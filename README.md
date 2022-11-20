### Data validator

#### Hexlet tests and linter status:

[![Actions Status](https://github.com/agsamkin/java-project-78/workflows/hexlet-check/badge.svg)](https://github.com/agsamkin/java-project-78/actions)

#### CI:

[![my-workflow](https://github.com/agsamkin/java-project-78/actions/workflows/my-workflow.yml/badge.svg)](https://github.com/agsamkin/java-project-78/actions/workflows/my-workflow.yml)

#### Codeclimate:

[![Maintainability](https://api.codeclimate.com/v1/badges/820e810888ace8131ab5/maintainability)](https://codeclimate.com/github/agsamkin/java-project-78/maintainability)
[![Test Coverage](https://api.codeclimate.com/v1/badges/820e810888ace8131ab5/test_coverage)](https://codeclimate.com/github/agsamkin/java-project-78/test_coverage)

#### Usage:

```
Validator v = new Validator();
StringSchema schema = v.string();

schema.isValid(""); // true
// Until the required() method is called, null is valid
schema.isValid(null); // true

schema.required();

schema.isValid("what does the fox say"); // true
schema.isValid("hexlet"); // true
schema.isValid(null); // false
schema.isValid(5); // false
schema.isValid(""); // false

schema.contains("wh").isValid("what does the fox say"); // true
schema.contains("what").isValid("what does the fox say"); // true
schema.contains("whatthe").isValid("what does the fox say"); // false
```

#### Validator types:

* String
* Number
* Map (and map keys)
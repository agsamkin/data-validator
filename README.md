### Data validator

#### CI:

[![my-workflow](https://github.com/agsamkin/java-project-78/actions/workflows/my-workflow.yml/badge.svg)](https://github.com/agsamkin/java-project-78/actions/workflows/my-workflow.yml)

#### Codeclimate:

[![Maintainability](https://api.codeclimate.com/v1/badges/820e810888ace8131ab5/maintainability)](https://codeclimate.com/github/agsamkin/java-project-78/maintainability)
[![Test Coverage](https://api.codeclimate.com/v1/badges/820e810888ace8131ab5/test_coverage)](https://codeclimate.com/github/agsamkin/java-project-78/test_coverage)

#### Validator types:

* String
* Number
* Map (and map keys)

#### Usage:

* String schema:

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

* Number schema:

```
Validator v = new Validator();
NumberSchema schema = v.number();

// Until the required() method is called, null is valid
schema.isValid(null); // true
schema.positive().isValid(null); // true

schema.required();

schema.isValid(null); // false
schema.isValid(10) // true
schema.isValid("5"); // false
schema.isValid(-10); // false
schema.isValid(0); // false

schema.range(5, 10);

schema.isValid(5); // true
schema.isValid(10); // true
schema.isValid(4); // false
schema.isValid(11); // false
```

* Map schema:

```
Validator v = new Validator();
MapSchema schema = v.map();

schema.isValid(null); // true

schema.required();

schema.isValid(null) // false
schema.isValid(new HashMap()); // true
Map<String, String> data = new HashMap<>();
data.put("key1", "value1");
schema.isValid(data); // true

schema.sizeof(2);

schema.isValid(data);  // false
data.put("key2", "value2");
schema.isValid(data); // true
```

* Map keys schema:

```
Map<String, BaseSchema> schemas = new HashMap<>();
schemas.put("name", v.string().required());
schemas.put("age", v.number().positive());
schema.shape(schemas);

Map<String, Object> human1 = new HashMap<>();
human1.put("name", "Kolya");
human1.put("age", 100);
schema.isValid(human1); // true

Map<String, Object> human2 = new HashMap<>();
human2.put("name", "Maya");
human2.put("age", null);
schema.isValid(human2); // true

Map<String, Object> human3 = new HashMap<>();
human3.put("name", "");
human3.put("age", null);
schema.isValid(human3); // false
```
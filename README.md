# Test cases for Phantom bugs

## Branch / bug

*master* - if allow filtering is used cassandra allows to query any column. Does not have to be indexed or part of primary key
*tuplepkey* - Table creation fails due to incorrect syntax generated if partition key is tuple type. *FIXED*
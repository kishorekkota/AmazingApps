

def variable = 100..10;

variable.each {println it}

variable.eachWithIndex { it,  p -> println "$p: $it" }


contained = variable.containsAll([10,20,30])

println(contained)

def mapIt = ['test':'value1212','hello':'world','this':'that','cat':'']

println  mapIt.test123 ? "got it" : 'not found'


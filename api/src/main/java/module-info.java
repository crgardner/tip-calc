module com.crg.api {
    requires transitive spark.core;
    requires joda.money;
    requires transitive com.crg.boundary;

    exports com.crg.api.hello;
    exports com.crg.api.tip;
}
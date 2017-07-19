addSbtPlugin("com.lightbend.cinnamon" % "sbt-cinnamon" % "2.4.2") // Cinnamon plugin

credentials += Credentials(Path.userHome / ".lightbend" / "commercial.credentials") // Specify the path of the file created in step 1 above which contains bintray credentials

resolvers += Resolver.url("lightbend-commercial",
 url("https://repo.lightbend.com/commercial-releases"))(Resolver.ivyStylePatterns)
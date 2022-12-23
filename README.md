## King Killers Loot System Point Calculation Tool
View the webpage at [Point Calculation Tool](https://jpw87.github.io/kingkillers/public/)
## Project
This project serves two purposes:
- Provide a fast and easy point calculation tool for the loot system used by  World of Warcraft: Wrath of the Lich King Classic guild Regicide
- A fun side project to learn clojure/clojurescript for the developer

### Details
This is a clojurescript + reagent project. All of the javascript and nearly all of the HTML is generated by clojurescript. All of the code is run in client-side javascript. There is no state/data stored by the application.

### Development mode
- After starting repl go to http://localhost:3000/
- Code changes are hot reloaded
```
npm install
npx shadow-cljs watch app
```
start a ClojureScript REPL
```
npx shadow-cljs browser-repl
```
### Running unit tests
- May require installing karma: `npm install -D karma karma-chrome-launcher karma-cljs-test`
- See package.json for where npm task `test` is defined 
  - Essentially all code is compiled to javascript and then tests in src/test is run in headless browser karma
```
npm run test
```
### Building for production
This command will create a smaller minified app.js file that has dead code removed.
```
npx shadow-cljs release app
```
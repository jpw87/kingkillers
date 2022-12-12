## King Killers Loot System Point Calculation Tool
View the webpage at [Point Calculation Tool](https://jpw87.github.io/kingkillers/public/)

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
### Building for production
This command will create a smaller minified app.js file that has dead code removed.
```
npx shadow-cljs release app
```
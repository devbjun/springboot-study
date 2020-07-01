const path = require('path');

module.exports = {
  context: path.resolve(__dirname, 'src/main/resources/templates/tsx'),
  entry: './App.tsx',
  output: {
    path: path.resolve(__dirname, 'src/main/resources/static/js/bundled'),
    filename: './[name].bundle.js'
  },
  devtool: 'sourcemaps',
  resolve: {
    extensions: [ '.ts', '.tsx', '.js', '.jsx' ]
  },
  module: {
    rules: [
      {
        test: /\.(ts|tsx)?$/,
        exclude: /(node_modules)/,
        use: [ 'ts-loader' ]
      },
      {
        test: /\.(sa|sc|c)ss$/,
        use: [ 'css-loader', 'sass-loader' ]
      }
    ]
  }
};
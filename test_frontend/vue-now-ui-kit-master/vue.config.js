module.exports = {
  devServer: {
      proxy: {
        '/account': {
          target: 'http://localhost:3000',
          ws:true,
          changeOrigin:true
        }
      }
  },
  runtimeCompiler: true,
  outputDir: '../../src/main/resources/static/',

  css: {
    // Enable CSS source maps.
    sourceMap: process.env.NODE_ENV !== 'production'
  }
};

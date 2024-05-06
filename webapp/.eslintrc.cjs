module.exports = {
  env: {
      browser: true,
      es2021: true,
  },
  extends: ['standard', 'plugin:react/recommended', 'plugin:react/jsx-runtime', 'prettier'],
  overrides: [
      {
          env: {
              node: true,
          },
          files: ['.eslintrc.{js,cjs}'],
          parserOptions: {
              sourceType: 'script',
          },
      },
  ],
  parserOptions: {
      ecmaVersion: 'latest',
      sourceType: 'module',
  },
  plugins: ['react'],
  rules: {
      // Customize rules as per your project's needs
      'react/prop-types': 'off', // Disable prop-types as we use TypeScript for type checking
      'react/react-in-jsx-scope': 'off', // React is included in the JSX runtime in React 17+
      'react/jsx-uses-react': 'off', // React is not defined when using JSX runtime
      'react/jsx-uses-vars': 'warn', // Warn if variables used in JSX are not defined
      'no-unused-vars': 'warn', // Warn about unused variables
      'indent': ['error', 4], // Enforce consistent indentation with 4 spaces
      'semi': ['error', 'always'], // Enforce the use of semicolons at the end of each statement
  },
  settings: {
      react: {
          version: 'detect', // Automatically includes the React version
      },
  },
};
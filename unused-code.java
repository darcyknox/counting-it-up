try {
  return Math.multiplyExact(n, nck(n - 1, k - 1)) / k;
} catch (ArithmeticException e) {
  return 0;
}

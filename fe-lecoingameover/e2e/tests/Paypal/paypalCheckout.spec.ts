import { test, expect } from '@playwright/test';

test('test', async ({ page }) => {
  await page.goto('http://localhost:3000/');
  await page.getByRole('link', { name: 'carticon' }).click();
  await page.getByRole('button', { name: 'Checkout with PayPal' }).click();
  await page.getByPlaceholder('Email or mobile number').click();
  await page.getByPlaceholder('Email or mobile number').fill('sb-u5jlc36687419@personal.example.com');
  await page.getByRole('button', { name: 'Next' }).click();
  await page.getByPlaceholder('Password').click();
  await page.getByPlaceholder('Password').fill('bdL>3hG6');
  await page.getByRole('button', { name: 'Log In' }).click();
  await page.getByTestId('submit-button-initial').click();
  await page.getByRole('button', { name: 'Go Back to Homepage' }).click();
});